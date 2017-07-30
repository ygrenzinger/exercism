module Anagram (anagramsFor) where

import Data.List
import Data.Char

anagramsFor :: String -> [String] -> [String]
anagramsFor word = filter (predicate word)

predicate :: String -> String -> Bool
predicate word possibleAnagram =
  let
    word' = map toLower word
    possibleAnagram' = map toLower possibleAnagram
  in
    word' /= possibleAnagram' && sort word' == sort possibleAnagram'
