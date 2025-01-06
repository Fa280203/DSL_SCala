// Nom du projet
name := "WorkflowDSL"

// Version du projet
version := "0.1.0-SNAPSHOT"

// Version de Scala
scalaVersion := "3.3.1"

// Dépendances
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.16" % Test, // Pour les tests
  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4" // Pour la parallélisation
)

// Options de compilation
scalacOptions ++= Seq(
  "-deprecation",  // Avertissements de dépréciation
  "-feature",      // Avertissements de fonctionnalités spécifiques
  "-unchecked",    // Avertissements pour les types
  "-Xfatal-warnings" // Traite les avertissements comme des erreurs
)
