module DNA (toRNA) where

--import Data.Maybe(mapMaybe)

convertDnaStrand :: Char -> Maybe Char
convertDnaStrand strand =
    case strand of
        'G' -> Just 'C'
        'C' -> Just 'G'
        'T' -> Just 'A'
        'A' -> Just 'U'
        _ -> Nothing

toRNA ::  String -> Maybe String
toRNA = mapM convertDnaStrand
