module Bob (responseFor) where

import Data.Char

responseFor :: String -> String
responseFor input
  | trimedInput == "" = "Fine. Be that way!"
  | charsAreAllCapitals trimedInput = "Whoa, chill out!"
  | last trimedInput == '?' = "Sure."
  | otherwise = "Whatever."
  where trimedInput = trim input

charsAreAllCapitals :: String -> Bool
charsAreAllCapitals input = any isAlpha input && all isUpper (filter isAlpha input)

trim :: String -> String
trim = filter (not . isSpace)
