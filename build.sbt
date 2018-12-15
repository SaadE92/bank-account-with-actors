import sbt._
import Keys._
name := "bankaccount-core"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.17"
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.5.17"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"



