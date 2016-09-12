# largeMap
FastUtil example of Largemap (String->int). I came across an interesting problem recently where I had to store over 60 million key value(String->int) in a map. The default java collection is not suitable for this, however, there are quite a few alternative collections available. I picked fastutil and to further reduce the total memory I am storing the hash(instead of string) and only when there is a collision, I am storing the string in a regular map. 

For Random strings of length 50 char and Int value of 60 million records, there were about half million hash collisions. Memory consumed by 60million records (string->int) is occupying less than 700mb.
