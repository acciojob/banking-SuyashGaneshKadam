package com.driver;

import java.util.*;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        if(balance < 5000)
        {
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId = tradeLicenseId;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int n = this.tradeLicenseId.length();
        boolean isValid = true;
        Integer[] charFreq = new Integer[26];
        Arrays.fill(charFreq, 0);
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        for(int i=0 ; i<n ; i++)
        {
            charFreq[tradeLicenseId.charAt(i) - 'A']++;
            map.put(tradeLicenseId.charAt(i), map.getOrDefault(tradeLicenseId.charAt(i), 0) + 1);
            maxFreq = Math.max(maxFreq, charFreq[tradeLicenseId.charAt(i) - 'A']);
            if(isValid && i != n-1 && this.tradeLicenseId.charAt(i) == this.tradeLicenseId.charAt(i+1))
            {
                isValid = false;
            }
        }
        if(!isValid)
        {
            if(((n + 1) / 2) < maxFreq)
            {
                throw new Exception("Valid License can not be generated");
            }
            else
            {
                Arrays.sort(charFreq, Collections.reverseOrder());
                int idx = 0;
                boolean isEven = true;
                char[] arr = new char[n];
                for(int i=0 ; i<26 ; i++)
                {
                    char ch = 'A';
                    for(char c : map.keySet())
                    {
                        if(map.get(c) == charFreq[i])
                        {
                            ch = c;
                            break;
                        }
                    }
                    int freq = charFreq[i];
                    while(freq > 0)
                    {
                        while(arr[idx] >= 'A' && arr[idx] <= 'Z')
                        {
                            idx += 2;
                            if(idx >= n)
                            {
                                if(isEven)
                                {
                                    isEven = false;
                                    idx = 1;
                                }
                                else
                                {
                                    isEven = true;
                                    idx = 0;
                                }
                            }
                        }
                        arr[idx] = ch;
                        freq--;
                    }
                    if(map.containsKey(ch))
                    {
                        map.remove(ch);
                    }
                }
                this.tradeLicenseId = "";
                for(int i=0 ; i<n ; i++)
                {
                    this.tradeLicenseId += arr[i];
                }
            }
        }
    }

}
