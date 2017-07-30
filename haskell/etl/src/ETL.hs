module ETL (transform) where

import Data.Map (Map, toList, fromList)
import Data.Char (toLower)

transformTuple :: a -> String -> [(Char, a)]
transformTuple k = map (\c -> (toLower c, k))

transformListOfTuple :: [(a, String)] -> [(Char, a)]
transformListOfTuple = concatMap (uncurry transformTuple)

transform :: Map a String -> Map Char a
transform oldFormat = fromList $ transformListOfTuple $ toList oldFormat
