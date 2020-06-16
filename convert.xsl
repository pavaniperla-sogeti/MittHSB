<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:a ="http://microsoft.com/schemas/VisualStudio/TeamTest/2006" xmlns:b ="http://microsoft.com/schemas/VisualStudio/TeamTest/2010" >
	<xsl:output method="xml" indent="yes" encoding="UTF-8"/>
	<xsl:template match="*">
		<testsuites>
		 <xsl:variable name="buildName" select="//TestRun/@name"/>
      <xsl:variable name="numberOfTests" select="count(//TransactionSummaries/TransactionSummary)"/>
      <testsuite name="DSLLoadTest"
				tests="{$numberOfTests}">
			<xsl:for-each select="//TransactionSummaries/TransactionSummary">
				<testcase>
					<xsl:attribute name="classname"><xsl:value-of select="name()"/></xsl:attribute>
						<xsl:attribute name="name"><xsl:value-of select="@transactionName"/></xsl:attribute>
						<xsl:attribute name="totaltests"><xsl:value-of select="@transactionCount"/></xsl:attribute>
						<xsl:attribute name="time"><xsl:value-of select="@responseTime div 1000"/></xsl:attribute>
						<xsl:if test="assertionResult/failureMessage">
							<failure><xsl:value-of select="assertionResults/failureMessage"/></failure>
						</xsl:if>
						<xsl:if test="@s = 'false'">
							<xsl:if test="responseData">
								<error><xsl:value-of select="responseData"/></error>
							</xsl:if>
						</xsl:if>
					</testcase>				
				</xsl:for-each>
			</testsuite>
		</testsuites>
	</xsl:template>
</xsl:stylesheet>