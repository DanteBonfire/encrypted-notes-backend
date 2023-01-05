package com.example.crypto.sevices.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

//@Component
//@RequiredArgsConstructor
class GFG {

    // Function generates the encoded text
    static String encoder(char[] key) {
        String encoded = "";

        // This array represents the
        // 26 letters of alphabets
        boolean[] arr = new boolean[26];

        // This loop inserts the keyword
        // at the start of the encoded string
        for (char c : key) {
            if (c >= 'A' && c <= 'Z') {
                // To check whether the character is inserted
                // earlier in the encoded string or not
                if (!arr[c - 65]) {
                    encoded += (char) c;
                    arr[c - 65] = true;
                }
            } else if (c >= 'a' && c <= 'z') {
                if (!arr[c - 97]) {
                    encoded += (char) (c - 32);
                    arr[c - 97] = true;
                }
            }
        }

        // This loop inserts the remaining
        // characters in the encoded string.
        for (int i = 0; i < 26; i++) {
            if (!arr[i]) {
                arr[i] = true;
                encoded += (char) (i + 65);
            }
        }
        return encoded;
    }

    // Function that generates encodes(cipher) the message
    static String cipheredIt(String msg, String encoded) {
        String cipher = "";

        // This loop ciphered the message.
        // Spaces, special characters and numbers remain same.
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) >= 'a' && msg.charAt(i) <= 'z') {
                int pos = msg.charAt(i) - 97;
                cipher += encoded.charAt(pos);
            } else if (msg.charAt(i) >= 'A' && msg.charAt(i) <= 'Z') {
                int pos = msg.charAt(i) - 65;
                cipher += encoded.charAt(pos);
            } else {
                cipher += msg.charAt(i);
            }
        }
        return cipher;
    }
}