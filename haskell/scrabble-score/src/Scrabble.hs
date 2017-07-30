module Scrabble (scoreLetter, scoreWord) where

import Data.Char (toUpper)
import Data.Map (Map, fromList, findWithDefault)

dict :: Map Char Int
dict = fromList [
  ('A', 1), ('B', 3), ('C', 3), ('E', 1), ('D', 2),
  ('G', 2), ('F', 4), ('I', 1), ('H', 4), ('K', 5),
  ('J', 8), ('M', 3), ('L', 1), ('O', 1), ('N', 1),
  ('Q', 10), ('P', 3), ('S', 1), ('R', 1), ('U', 1),
  ('T', 1), ('W', 4), ('V', 4), ('Y', 4), ('X', 8), ('Z', 10)]

scoreLetter :: Char -> Int
scoreLetter l = findWithDefault 0 (toUpper l) dict

scoreWord :: String -> Int
scoreWord w = sum $ map scoreLetter w
