module DNA (count, nucleotideCounts) where

import Data.Map (Map, fromList, unionWith, mapKeys)
import Data.List
import Data.Maybe
import Control.Arrow

data NucleotideType = A | C | G | T deriving (Eq, Ord, Show, Read)

toNucleotideType :: Char -> Maybe NucleotideType
toNucleotideType c =
  case c of
    'A' -> Just A
    'C' -> Just C
    'G' -> Just G
    'T' -> Just T
    _ -> Nothing

fromNucleotideType :: NucleotideType -> Char
fromNucleotideType n =
  case n of
    A -> 'A'
    C -> 'C'
    G -> 'G'
    T -> 'T'

nucleotides :: [NucleotideType]
nucleotides = [A, C, G, T]

initNucleotidesCounts :: Map NucleotideType Int
initNucleotidesCounts = fromList (zip nucleotides (repeat 0))

frequencies :: Ord a => [a] -> Map a Int
frequencies = fromList . map (head &&& length) . group . sort

nucleotidesFrequencies :: [NucleotideType] -> Map Char Int
nucleotidesFrequencies dna = mapKeys fromNucleotideType (unionWith (+) initNucleotidesCounts (frequencies dna))
-- Don't know how to simplify this line

count :: Char -> String -> Either String Int
count strand dna
  | isNothing strand' = Left "incorrect strand"
  | any isNothing dna' = Left "incorrect dna"
  | otherwise = Right (length (filter (strand' ==) dna'))
  where
    strand' = toNucleotideType strand
    dna' = map toNucleotideType dna

nucleotideCounts :: String -> Either String (Map Char Int)
nucleotideCounts dna
  | any isNothing dna' = Left "incorrect dna"
  | otherwise = Right (nucleotidesFrequencies $ catMaybes dna')
  where dna' = map toNucleotideType dna
