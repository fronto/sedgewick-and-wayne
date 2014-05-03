name := "sedgewick-and-wayne"

version := "1.0"

scalaVersion := "2.10.2"

unmanagedSourceDirectories in Compile += baseDirectory.value / "booksite"

libraryDependencies ++=  Seq("junit" % "junit" % "4.11" % "test", "com.novocode" % "junit-interface" % "0.9" % "test")

exportJars := true