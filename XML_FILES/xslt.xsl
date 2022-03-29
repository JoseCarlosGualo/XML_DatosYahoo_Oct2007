<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:output method='html'/>
 <xsl:template match="/">
  <html>
   <head>
    <title>Yahoo Answers</title>
   </head> 
   <body>

    <link rel="stylesheet" type="text/css" href="/Archivos/style.css" />
    <header>
     <h1 id="header">Yahoo Answers</h1>
    </header>

     <div id="desarrolladores">
      <h2>Desarrolladores:</h2>
      <ul>
       <li>Jose Carlos Gualo Cejudo</li>
       <br/>
       <li>Jorge Sanchez Ramos</li>
      </ul>
     </div>

     <div>
      <table border="1">
        <tr bgcolor="#FDFEFE" style="text_align: center;"> 
          <th>Categoria</th>
          <th>Subcategoria</th>
          <th>Pregunta</th> 
          <th>Mejor Respuesta</th>
        </tr>
        <xsl:for-each select="ystfeed/vespaadd/document"> 
          <tr>
            <td style="color:black"><xsl:value-of select="maincat"/></td> 
            <td style="color:black"><xsl:value-of select="subcat"/></td> 
            <td style="color:black"><xsl:value-of select="subject"/></td> 
            <td style="color:black"><xsl:value-of select="bestanswer"/></td>
          </tr>
        </xsl:for-each>
      </table> 
    </div>
    <footer style="margin-top: 50px;">
      <br/>
      <h3>Trabajo Yahoo Answers ---- Grupo Gualo-Sanchez ----</h3>
    </footer>
   </body>
  </html>
 </xsl:template> 
</xsl:stylesheet>