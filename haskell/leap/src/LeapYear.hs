module LeapYear (isLeapYear) where

type Year = Integer

isMultipleOf year divisor = year `mod` divisor == 0



isLeapYear :: Year -> Bool
isLeapYear year | year `isMultipleOf` 400 = True
isLeapYear year | year `isMultipleOf` 100 = False
isLeapYear year | year `isMultipleOf` 4   = True
isLeapYear _ 				= False  
