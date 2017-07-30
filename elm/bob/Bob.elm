module Bob exposing (..)

import String 

hey : Maybe String -> String
helloWorld name =
  case name of
    Nothing -> "Hello, World!"
    Just name -> "Hello, " ++ name ++ "!"
