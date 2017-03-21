
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="wf" uri="http://www.mathworks.com/builderja/webfigures.tld" %>
<html>
<body>
	<h1>Spring MVC Hello World Example</h1>

	<h2>${msg} jedna</h2>
        <p>
                
        ${webFig}
        </p>
        test
        

        
        <form action="upload.form" enctype="multipart/form-data" method="POST" >
                <input type="file"  name="file" >
                <input type="submit" value="Upload files">

        </form>
 <form action="upload.form"  method="POST">
  First name:<br>
  <input type="text" name="firstname" value="Mickey"><br>
  Last name:<br>
  <input type="text" name="lastname" value="Mouse"><br><br>
  <input type="submit" value="Submit">
</form>             
            <p>
                
        ${webFig2}
        </p>
        
                    <script>
            function updateSize() {
                var nBytes = 0,
                        oFiles = document.getElementById("fileInput").files,
                        nFiles = oFiles.length;
                for (var nFileId = 0; nFileId < nFiles; nFileId++) {
                    nBytes += oFiles[nFileId].size;
                }

                var sOutput = nBytes + " bytes";
                // optional code for multiples approximation
                for (var aMultiples = ["KiB", "MiB", "GiB", "TiB", "PiB", "EiB", "ZiB", "YiB"], nMultiple = 0, nApprox = nBytes / 1024; nApprox > 1; nApprox /= 1024, nMultiple++) {
                    sOutput = nApprox.toFixed(3) + " " + aMultiples[nMultiple] + " (" + nBytes + " bytes)";
                }
                // end of optional code

                document.getElementById("fileNum").innerHTML = nFiles;
                document.getElementById("fileSize").innerHTML = sOutput;
            }
        </script>        
        
        ${message2}
        ${message}
        ${webfig}
</body>
</html>