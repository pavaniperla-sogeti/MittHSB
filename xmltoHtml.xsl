<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="yes"/>
	<xsl:template match="/">
		<html>
			<head>
				<style>
html,
body,
form,
fieldset,
h2,
h3,
h4,
h5,
h6,
p,
pre,
blockquote,
ul,
ol,
dl,
address {
    margin: 0;
    padding: 0;
}

#floatingImageBackground {
    position: fixed;
    display: none;
    top: 50%;
    left: 50%;
    margin-top: -300px;
    margin-left: -330px;
    z-index: 100;
    width: 680px;
    height: 600px;
    visibility: hidden;
    background-color: #fff;
    background-repeat: no-repeat;
    border: 2px #0f9bdc;
    border-style: solid;
}

#floatingImage {
    position: relative;
    margin-left: 8%;
    margin-top: 6%;
    width: auto;
    max-width: 566px;
}

.floatingImageCloseButton {
    background-image: url('data:image/png;base64,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');
    font-size: 50px;
    width: 40px;
    height: 40px;
    position: relative;
    bottom: 20px;
    left: 3%;
    text-align: center;
    cursor: pointer;
    float: right;
    background-repeat: no-repeat;
}

.atachmentImage {
    float: right;
    cursor: pointer;
    width: 20px;
    height: 20px;
    background-size: 20px 20px;
    background-image: url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgBAMAAACBVGfHAAAAJFBMVEUAAAD///8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAW+S7RAAAAC3RSTlMAABBAYHCfv8/f7y5wfg4AAACNSURBVHhendC9DYMwFEXhq0BEi7egTJEBIlHSuKdhBHpGYARGSEtA8JaDBwjbt0Aop/zk5z8Y6gZoh8KVyVrl4NEqDDiXZ7JVGZPu0O4wbPDsxGuyKCXoh28IM4Q6YMzfTQAfIPahx1rhQa2QONAJnXHwUoiugEd4Uz6WL8ZXF4qfP/EH9fSFs4Wh/oAFE9baEPQEC+YAAAAASUVORK5CYIIyNjk=');
}


#exceptionArrow {
    float: left;
    font-size: 20px;
}

.wrapOverall {
    width: auto;
    margin: -8px 0px 0px 0px;
    height: auto;
    margin-left: auto;
    margin-right: auto;
}

h1 {
    font-size: 15px;
}

body {
    font: 16px/20px "Trebuchet MS",Verdana,Arial,Helvetica,sans-serif;
    margin-top: -10px;
    min-width: 890px;
}

p {
    text-align: center;
}

a:link {
    color: #d42945;
    text-decoration: none;
    border-bottom: 1px dotted #ffbac8;
}

a:visited {
    color: #d42945;
    border-bottom: none;
    text-decoration: none;
}

a:hover,
a:focus {
    color: #f03b58;
    border-bottom: 1px solid #f03b58;
    text-decoration: none;
}


.StatusesBorders {
    border-width: 0;
    border-right: 1px solid;
    border-left: 1px solid;
    width: 100px;
}

.PackageStatus {
    width: 100px;
}

.SummaryTable {
    width: auto;
    max-width: 607px;
    float: left;
    margin-right: 20px;
}

#divToRefresh > div > table.SummaryTable > tbody > tr > th {
    width: auto;
}

.DetailsTable {
    width: auto;
    max-width: 407px;
    float: left;
    margin-right: 20px;
    text-align: left;
    word-wrap: break-word;
}

.StatusesTable {
    width: auto;
}

#divToRefresh > div.SummaryDiv > table.DetailsTable > tbody > tr > td {
    text-align: left;
    word-wrap: break-word;
}

#divToRefresh > div.SummaryDiv > table.DetailsTable > tbody > tr > th {
    width: 30px;
    /*background-color: #FFFFFF;*/
}

td.slowest {
    width: auto;
}

#TotalTestsTable {
    min-width: 250px;
    width: auto;
    float: left;
    margin-right: 20px;
}

.SummaryDiv {
    width: 90%;
    border-top: 1px solid #e5eff8;
    border-right: 1px solid #e5eff8;
    margin: 1em auto;
    border-collapse: collapse;
}

.Summary {
    float: left;
    border-collapse: collapse;
}

#btn-download {
    font-size: 14px;
}

.column1 {
    background: #dbedff;
    width: 170px;
}

.column1Failed {
    background: #fed9d9;
    width: 30px;
}

#ReportsTable > tbody > tr > th {
    background: #E8E8E8;
    width: 170px;
}

#ReportsTable th {
}

#TotalPassed {
    min-width: 30px;
    width: auto;
    height: auto;
    color: #7CCD7C;
    background: #c0eec0;
    border: 1px solid #7CCD7C;
    margin-bottom: 5px;
}

#TotalWarn {
    min-width: 30px;
    width: auto;
    height: auto;
    color: #E4C100;
    background: #FBE87E;
    border: 1px solid #E4C100;
    margin-bottom: 5px;
}

#TotalFailed {
    min-width: 30px;
    width: auto;
    height: auto;
    color: #d42945;
    background: #fed9d9;
    border: 1px solid #d42945;
    margin-bottom: 5px;
}

#TotalInfo {
    min-width: 30px;
    width: auto;
    height: auto;
    border: 1px solid #c7c7c7;
    color: #c7c7c7;
    background: #e0e0e0;
}

#dataViewer {
    width: 240px;
}

.OpenMoreButton {
    height: auto;
    width: 200px;
    cursor: pointer;
    text-decoration: none;
    text-align: center;
    color: #1b99fb;
    background-color: white;
    border: 1px solid #7ac5ff;
    float: right;
}

    .OpenMoreButton:hover {
        background-color: #bfe3ff;
        text-decoration: none;
    }



#MoreButtonText {
    color: #1b99fb;
    top: 0;
    left: 25px;
    font-weight: normal;
    text-align: center;
    font-size: 15px;
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
}

.NumberTag {
    display: inline;
    padding-left: 3px;
    padding-right: 3px;
    margin-right: 4px;
    height: auto;
    color: #678197;
    border: 1px solid #78bcff;
    background-color: #ffffff;
    border-radius: 8px;
    text-align: center;
    margin-bottom: 2px;
    line-height: 27px;
}

.NumberTagRed {
    background-color: #fed9d9;
}

.NumberTagGreen {
    background-color: #c0eec0;
}

.NumberTagYellow {
    background-color: #FBE87E;
}

.hiddenRow {
    display: none;
    visibility: hidden;
}

.visibleRow {
    visibility: visible;
}
			</style>
			<style>table a,
table a:link,
table a:visited {
    border: none;
}

img {
    border: 0;
    margin-top: .5em;
}

table {
    width: 90%;
    margin: 1em auto;
    border-collapse: collapse;
    border: 1px solid #a2caf2;
}

caption {
    color: #9ba9b4;
    font-size: 16px;
    letter-spacing: .2em;
    margin: 1em 0 0 0;
    padding: 0;
    caption-side: top;
    text-align: center;
    font-weight: normal;
    border-top: 1px solid #a2caf2;
    border-left: 1px solid #a2caf2;
    border-right: 1px solid #a2caf2;
}

tr.odd .column1 {
    background: #dbedff;
}

tr.odd.column1Failed	{
	background:#fed9d9;
	width:30px;
	}

tr.odd td, tr.sep td {
    background: #FFFFFF;
}

tr.sep .column1 {
    background: #7CCD7C;
}

tr.odd .ex,
tr.sep .ex,
td.ex {
    text-align: left;
    width: 100px;
}

td.exShow {
    text-align: left;
    width: 100px;
    color: #000;
}

td.statusCount {
    width: auto;
}

th.statusCount {
    width: auto;
}

td.critical {
    text-align: left;
    width: 100px;
}

td.Message {
    text-align: left;
    width: auto;
    word-wrap: break-word;
}

.Atached {
    width: 30px
}

td.Function {
    text-align: left;
}

tr.sep .error,
tr.odd .error,
td.error {
    background: #F08080;
}

tr.odd .warn,
tr.sep .warn,
td.warn {
    color: #E4C100;
    background: #FBE87E;
    width: 90px;
}

tr.odd .info,
td.info,
tr.sep .info {
    color: #c7c7c7;
    background: #e0e0e0;
    width: 90px;
}

tr.odd .failed,
tr.sep.failed,
td.failed {
    color: #d42945;
    background: #fed9d9;
    width: 90px;
}

tr.odd .passed,
tr.sep.passed,
td.passed {
    color: #7CCD7C;
    background: #c0eec0;
    width: 90px;
}

td {
    color: #425b71;
    ;
    padding: .3em 1em;
    text-align: center;
    border-left: 1px solid #a2caf2;
    border-top: 1px solid #a2caf2;
    word-wrap: break-word;
}

th {
    font-weight: normal;
    color: #678197;
    text-align: left;
    border-left: 1px solid #a2caf2;
    border-top: 1px solid #a2caf2;
    padding: .3em 1em;
}

thead th.TestsTable {
    font-size: 17px;
    font-weight: normal;
}

thead th {
    background: #dbedff;
    text-align: center;
    font: bold 1.2em/2em "Century Gothic","Trebuchet MS",Arial,Helvetica,sans-serif;
    color: #66a3d3;
}

tfoot th {
    text-align: center;
    background: #f4f9fe;
}

    tfoot th strong {
        font: bold 1.2em "Century Gothic","Trebuchet MS",Arial,Helvetica,sans-serif;
        margin: .5em .5em .5em 0;
        color: #678197;
    }

    tfoot th em {
        color: #678197;
        font-weight: bold;
        font-size: 1.1em;
        font-style: normal;
    }
			</style>
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