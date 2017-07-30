module Raindrops (convert) where

factors :: [(Int, String)]
factors = [(3, "Pling"),(5, "Plang"),(7, "Plong")]

convertForFactor :: Int -> (Int, String) -> String
convertForFactor n (f, s) = if n `mod` f == 0 then s else ""

convert :: Int -> String
convert n = if v == "" then show n else v
  where v = concatMap (convertForFactor n) factors
