module Grains (square, total) where

import Data.Maybe(mapMaybe)

square :: Integer -> Maybe Integer
square x | (x > 0) && (x < 65) = Just (2 ^ (x-1))
         | otherwise = Nothing

total :: Integer
total = sum $ mapMaybe square [1..64]
