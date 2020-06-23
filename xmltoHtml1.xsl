<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="yes"/>
	<xsl:template match="/">
		<html>
			<head>
				
			<title>
         Testing
			</title>
		</head>
		<body>
			<div id="divToRefresh" class="wrapOverall">
  <div id="floatingImageBackground" class="floatingImageBackground" style="visibility: hidden;">
        <div class="floatingImageCloseButton" onclick="hide('floatingImageBackground');"></div><img src="" id="floatingImage"/></div>

				<br>
					<center>
						<h1>DSL Load Test Result</h1>
					</center>
				</br>
						
	<br></br>
	
	<table class="SummaryTable">
          <caption>Run Time Summary</caption>
          <tbody>
            <tr class="odd">
              <th class="column1">Start Time</th>
              <td><xsl:value-of select="//@finish" /></td>
            </tr>
            <tr>
              <th class="column1">End Time</th>
              <td><xsl:value-of select="//@finish" /></td>
            </tr>
            <tr>
              <th class="column1">Total Services</th>
              <td><xsl:value-of select="count(//TransactionSummaries/TransactionSummary)" /></td>
            </tr>
			<tr>
              <th class="column1">Total failures</th>
              <td><xsl:value-of select="sum(//@testsFailed)" /></td>
            </tr>
			<tr>
              <th class="column1">Total hits</th>
              <td><xsl:value-of select="sum(//@totalTests)" /></td>
            </tr>
			<tr>
              <th class="column1">Test status</th>
              <td><xsl:value-of select="//@outcome" /></td>
            </tr>
          </tbody>
        </table>
		
		  <table class="DetailsTable">
          <caption>Tests Details</caption>
          <tbody>
            <tr class="odd">
              <th class="column1">User</th>
              <td><xsl:value-of select="//@runUser" /></td>
            </tr>
            <tr>
              <th scope="row" class="column1">Machine</th>
              <td><xsl:value-of select="//@machineName" /></td>
            </tr>
            <tr>
              <th scope="row" class="column1">Description</th>
              <td>
              </td>
            </tr>
          </tbody>
        </table>
	<div class="SummaryDiv">
	<!--	<center><h5>Test Start Time:: <xsl:value-of select="//@start" /></h5>
		<h5>Test End Time:: <xsl:value-of select="//@finish" /></h5>
		<h5>Total Services:: <xsl:value-of select="count(//TransactionSummaries/TransactionSummary)" /></h5>
		<h5>Total failures:: <xsl:value-of select="sum(//@testsFailed)" /></h5>
		<h5>Total hits:: <xsl:value-of select="sum(//@totalTests)" /></h5>
		<h5>Test status:: <xsl:value-of select="//@outcome" /></h5></center>
				
		<xsl:for-each select="//PerformanceCounterResults>/PerformanceCounterResult">
		 <xsl:if test="@counterName = 'Failed Tests'">
		 <h5>No of Failures:: <xsl:value-of select="//@value" /></h5></xsl:if>
		 </xsl:for-each>
		<h5>Total Transactions:: <xsl:value-of select="//@finish" /></h5>
		<h5>Average Throughput:: <xsl:value-of select="//@finish" /></h5>
		<h5>No of Failures:: <xsl:value-of select="//@finish" /></h5>
		<h5>Test Status:: <xsl:value-of select="//@finish" /></h5>
		-->
		 <table id="ReportsTable">
        <caption>Load Test Result Details</caption>
        <thead>
          <tr class="odd">
            <th scope="col">TransactionName</th>
           <th scope="col">Transaction count</th>
           <th scope="col">Average Response Time</th>
		     <th scope="col">No of Faliures</th>
          </tr>
        </thead>
        <tbody>
	 
	
				<!--<table style="width:100%;" border="1">
					<tr>
					<th class="column1 statusCount">Total</th>
						<td>
							<h1>TransactionName</h1>
						</td>
						<td>
							<h1>Transaction count</h1>
						</td>
						<td>
							<h1>Average Response Time</h1>
						</td>
						<td>
							<h1>No of Faliures</h1>
						</td>
					</tr>-->
					<xsl:for-each select="//TestSummaries/TestSummary">
						<tr>
						
							<td>
								<xsl:value-of select="@testName"/>
							</td>
							<td>
								<xsl:value-of select="@totalTests"/>
							</td>
							<td>
								<xsl:value-of select="@averageDuration div 1000"/>
							</td>
							<td>
								<xsl:value-of select="@testsFailed"/>
							</td>
						</tr>
					</xsl:for-each>
					</tbody>
				</table>
</div>	
			</div>				
		</body>
	</html>
</xsl:template>
</xsl:stylesheet>
