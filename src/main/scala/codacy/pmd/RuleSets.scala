package codacy.pmd

import codacy.docker.api.{Pattern, Result}

object RuleSets extends Enumeration {
  type RuleSets = Value

  val braces = Value("braces")
  val empty = Value("empty")
  val strictsyntax = Value("strictsyntax")
  val dates = Value("dates")
  val basic = Value("basic")
  val j2ee = Value("j2ee")
  val unusedcode = Value("unusedcode")
  val comments = Value("comments")
  val TomKytesDespair = Value("TomKytesDespair")
  val naming = Value("naming")
  val migrating = Value("migrating")
  val design = Value("design")
  val loggingJava = Value("logging-java")
  val sunsecure = Value("sunsecure")
  val strings = Value("strings")
  val basicJsf = Value("basic-jsf")
  val unnecessary = Value("unnecessary")
  val controversial = Value("controversial")
  val strictexception = Value("strictexception")
  val junit = Value("junit")
  val javabeans = Value("javabeans")
  val optimizations = Value("optimizations")
  val coupling = Value("coupling")
  val finalizers = Value("finalizers")
  val xpath = Value("xpath")
  val imports = Value("imports")
  val codesize = Value("codesize")
  val loggingJakartaCommons = Value("logging-jakarta-commons")
  val cloneImplementation = Value("clone")
  val android = Value("android")

  def getRuleSet(name: String): Option[RuleSets.Value] = RuleNameToSet.get(name)

  def getLevelAndCategory(simpleName: String): Option[(Result.Level.Value, Pattern.Category.Value)] = {
    RuleNameToSet.get(simpleName)
      .orElse {
        RuleSets.values.find { v =>
          v.toString.equalsIgnoreCase(simpleName)
        }
      }.flatMap(RuleSetToLevelAndCategory.get)
  }

  private lazy val RuleNameToSet = {
    Map(
      "Code Size" -> codesize,
      "Optimization" -> optimizations,
      "Basic Ecmascript" -> basic,
      "Basic POM" -> basic,
      "Comments" -> comments,
      "Braces" -> braces,
      "JavaBeans" -> javabeans,
      "PLSQL DATETIME" -> dates,
      "Android" -> android,
      "Basic JSP" -> basic,
      "Import Statements" -> imports,
      "Jakarta Commons Logging" -> loggingJakartaCommons,
      "Migration" -> migrating,
      "Basic JSF" -> basicJsf,
      "Strict Syntax" -> strictsyntax,
      "Strict Exceptions" -> strictexception,
      "JUnit" -> junit,
      "Basic XML" -> basic,
      "Design" -> design,
      "Security Code Guidelines" -> sunsecure,
      "Tom Kyte's Despair" -> TomKytesDespair,
      "Clone Implementation" -> cloneImplementation,
      "Finalizer" -> finalizers,
      "Basic Velocity" -> basic,
      "Basic" -> basic,
      "XPath in XSL" -> xpath,
      "Empty Code" -> empty,
      "Java Logging" -> loggingJava,
      "Naming" -> naming,
      "Coupling" -> coupling,
      "Unnecessary" -> unnecessary,
      "String and StringBuffer" -> strings,
      "Unused Code" -> unusedcode,
      "Controversial" -> controversial,
      "J2EE" -> j2ee
    )
  }

  private lazy val RuleSetToLevelAndCategory = {
    Map(
      android -> (Result.Level.Warn, Pattern.Category.ErrorProne),
      braces -> (Result.Level.Info, Pattern.Category.CodeStyle),
      cloneImplementation -> (Result.Level.Warn, Pattern.Category.Compatibility),
      codesize -> (Result.Level.Warn, Pattern.Category.ErrorProne),
      comments -> (Result.Level.Info, Pattern.Category.CodeStyle),
      coupling -> (Result.Level.Warn, Pattern.Category.ErrorProne),
      finalizers -> (Result.Level.Warn, Pattern.Category.ErrorProne),
      imports -> (Result.Level.Info, Pattern.Category.UnusedCode),
      j2ee -> (Result.Level.Warn, Pattern.Category.CodeStyle),
      junit -> (Result.Level.Warn, Pattern.Category.CodeStyle),
      javabeans -> (Result.Level.Warn, Pattern.Category.ErrorProne),
      loggingJakartaCommons -> (Result.Level.Info, Pattern.Category.CodeStyle),
      loggingJava -> (Result.Level.Info, Pattern.Category.CodeStyle),
      strictexception -> (Result.Level.Warn, Pattern.Category.ErrorProne),
      strings -> (Result.Level.Warn, Pattern.Category.Performance),
      unnecessary -> (Result.Level.Warn, Pattern.Category.Performance),
      empty -> (Result.Level.Info, Pattern.Category.CodeStyle),
      design -> (Result.Level.Warn, Pattern.Category.ErrorProne),
      controversial -> (Result.Level.Warn, Pattern.Category.ErrorProne),
      optimizations -> (Result.Level.Warn, Pattern.Category.Performance),
      sunsecure -> (Result.Level.Err, Pattern.Category.ErrorProne),
      migrating -> (Result.Level.Info, Pattern.Category.Compatibility),
      naming -> (Result.Level.Info, Pattern.Category.CodeStyle),
      basic -> (Result.Level.Warn, Pattern.Category.ErrorProne),
      unusedcode -> (Result.Level.Warn, Pattern.Category.UnusedCode),
      strictsyntax -> (Result.Level.Warn, Pattern.Category.CodeStyle),
      dates -> (Result.Level.Warn, Pattern.Category.ErrorProne),
      TomKytesDespair -> (Result.Level.Warn, Pattern.Category.ErrorProne),
      basicJsf -> (Result.Level.Warn, Pattern.Category.ErrorProne),
      xpath -> (Result.Level.Warn, Pattern.Category.ErrorProne)
    )
  }

}
          