module Hamming (distance) where

distance :: String -> String -> Maybe Integer
distance [] _ = Just 0
distance _ [] = Just 0
distance xs ys | length xs /= length ys = Nothing
distance (x:xs) (y:ys) | x /= y = fmap (+1) (distance xs ys)
                       | otherwise = distance xs ys
