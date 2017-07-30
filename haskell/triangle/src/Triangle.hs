module Triangle (TriangleType(..), triangleType) where

import Data.List (nub, permutations)

data TriangleType = Equilateral
                  | Isosceles
                  | Scalene
                  | Illegal
                  deriving (Eq, Show)

triangleType a b c
  | isIllegal = Illegal
  | allSidesEqual = Equilateral
  | twoSidesEqual = Isosceles
  | noSidesEqual = Scalene
  where
    sides = [a,b,c]
    isIllegal = (hasZeroLengthSide sides) || (any violatesInequalityTheorem $ permutations sides)
    numberOfDistinctLengths = length $ nub $ sides
    allSidesEqual = (numberOfDistinctLengths == 1)
    twoSidesEqual = (numberOfDistinctLengths == 2)
    noSidesEqual = (numberOfDistinctLengths == 3)

hasZeroLengthSide :: [Double] -> Bool
hasZeroLengthSide [0,_,_] = True
hasZeroLengthSide [_,0,_] = True
hasZeroLengthSide [_,_,0] = True
hasZeroLengthSide _ = False

violatesInequalityTheorem :: [Double] -> Bool
violatesInequalityTheorem [a,b,c] = c > a + b
