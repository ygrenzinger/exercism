module School (School, add, empty, grade, sorted) where

import qualified Data.Map as Map
import Data.List (sort)

type Grade = Integer
type Name = String
type School = Map.Map Grade [Name]

add :: Grade -> Name -> School -> School
add g name = Map.insertWith (++) g [name]

empty :: School
empty = Map.empty

grade :: Grade -> School -> [Name]
grade g school = sort $ Map.findWithDefault [] g school

sorted :: School -> [(Grade, [Name])]
sorted school = Map.toAscList $ fmap sort school
