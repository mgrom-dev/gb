﻿Random rnd = new Random();
int a  = rnd.Next(1, 50);
int b   = rnd.Next(1, 50);
int c   = rnd.Next(1, 50);
int d   = rnd.Next(1, 50);
float sum = (float)(a * b) / (c + d);
Console.Write(a + " * " + b + " / (" + c + " + " + d + ") = ");
Console.WriteLine(sum);
