# Most-Popular-Names-in-USA-StreamAPI
Most popular names in USA for the past 100 of years. 

This project processes the files obtained from US Social Security Aministration (www.ssa.gov/OACT/babynames/),
which shows the most 1000 popular names for babies in the last 100 years.

The first two lines of the file are the base decade and the number of decades included for each line.
The base decade indicates the decade for the first rank.
The second line is an integer than indicates the number of decades for which each name is ranked. 
Each line in the rest of the file has names and the ranks for each decade.

A rank of 1 indicates the name was the most popular name that year, while a rank of 997 was not
very popular. 

A 0 in the data file means the name did not appear in the top 1000 that decade



The following project applies a series of algorithms using the StreamAPI in java to perform the following functionalities:

- a method that determines the best decade for each name. Break ties using the most
recent decade.
- a method that returns the number of decades that a name has been in the top 1000.
- a method that determines whether a name has become increasingly popular over each
decade in the time period covered (i.e strictly increasing).
- a method that determines whether a name has become decreasingly popular over each
decade in the time period covered (i.e strictly decreasing).
- a method that lists the names in order of popularity (most popular to least popular) for
a given decade, breaking ties alphabetically.


To run this repository:
- clone this repository on your machine(or download the zip file)
- open the project(IntelliJ recommended)
- have at least Java8 installed(recommended JDK11)
