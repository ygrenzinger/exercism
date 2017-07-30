module SumOfMultiples (sumOfMultiples) where

import Data.List

generateMultiples :: Integer -> Integer -> [Integer]
generateMultiples limit factor = takeWhile (< limit) $ map (* factor) [1..]

sumOfMultiples :: [Integer] -> Integer -> Integer
sumOfMultiples factors limit = sum $ nub $ concatMap (generateMultiples limit) factors
