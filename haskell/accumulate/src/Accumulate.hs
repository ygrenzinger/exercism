module Accumulate (accumulate) where

accumulate :: (a -> b) -> [a] -> [b]
accumulate fn [] = []
accumulate fn (x:xs) = fn x : accumulate fn xs
