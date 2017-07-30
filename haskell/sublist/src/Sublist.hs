module Sublist (Sublist(..), sublist) where

isInfixOf :: Eq a => [a] -> [a] -> Bool
isInfixOf [] _ = True
isInfixOf _ [] = False
isInfixOf x y | isPrefixOf x y = True
isInfixOf x (y:ys) = isInfixOf x ys

isPrefixOf              :: (Eq a) => [a] -> [a] -> Bool
isPrefixOf [] _         =  True
isPrefixOf _  []        =  False
isPrefixOf (x:xs) (y:ys)=  x == y && isPrefixOf xs ys

data Sublist = Equal|Sublist|Superlist|Unequal
  deriving (Eq, Show)

sublist :: Eq a => [a] -> [a] -> Sublist
sublist x y | x == y = Equal
            | x `isInfixOf` y = Sublist
            | y `isInfixOf` x = Superlist
            | otherwise = Unequal
