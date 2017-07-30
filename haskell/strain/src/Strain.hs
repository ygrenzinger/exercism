module Strain (keep, discard) where

keep :: Foldable f => (a -> Bool) -> f a -> [a]
keep p = foldr (\x -> if p x then (x:) else id) []

discard :: Foldable f => (a -> Bool) -> f a -> [a]
discard p = keep (not . p)
