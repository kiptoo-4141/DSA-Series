# 151. Reverse Words in a String

## Problem Description

Given an input string `s`, reverse the **order of the words**.

A **word** is defined as a sequence of non-space characters. The words in `s` will be separated by **at least one space**.

Return a string of the words in reverse order, concatenated by a **single space**.

> Note:  
> - The input string may contain **leading**, **trailing**, or **multiple spaces** between words.  
> - The output should have only **single spaces** separating words and **no leading or trailing spaces**.

---

## Examples

### Example 1:
**Input:**
s = "the sky is blue"

**Output:**
"blue is sky the"



### Example 2:
**Input:**
s = " hello world "


**Output:**
"world hello"



**Explanation:**  
Your reversed string should not contain leading or trailing spaces.

---

### Example 3:
**Input:**
s = "a good example"



**Output:**
"example good a"



**Explanation:**  
You need to reduce multiple spaces between two words to a single space in the reversed string.

---

## Constraints

- `1 <= s.length <= 10^4`
- `s` contains English letters (upper-case and lower-case), digits, and spaces `' '`.
- There is **at least one word** in `s`.
