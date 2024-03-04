<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Sports Club Altenstadt">
    <meta name="keywords" content="sports, tennis, football, altenstadt, austria, dynamic table, jsp">
    <meta name="author" content="Matthias Meier">
    <title>Sports Club Altenstadt - Dynamic Table</title>

    <!-- CSS -->
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" media="print" href="./css/print.css">

    <!-- JS -->
    <script src="./js/imagepopup.js"></script>
    <script src="./js/cookies.js"></script>
</head>
<body>
<!-- sidebar -->
<div class="sidenav">
    <a href="home.html" class="logo"><img src="./img/logo.png" alt="Sports Club Altenstadt" width="150px"></a>
    <a href="home.html">Home</a>
    <a href="tsv-altenstadt.html">TSV Altenstadt</a>
    <a href="tc-altenstadt.html">TC Altenstadt</a>
    <a href="guestbook">Guestbook</a>
    <a href="table.jsp" class="active">Dynamic Table</a>
    <a href="create-account.html">Create Account</a>
    <a href="mailto: matthias.meier97@hotmail.com"><img src="./img/email.png" class="icon" alt="E-Mail"
                                                        width="30px">Contact</a>
</div>

<!-- main -->
<div class="main">
    <h1>Dynamic Table</h1>

    <!-- table settings form -->
    <h2>Table Settings</h2>
    <form name="dynamicTable" action="table.jsp">
        <p>
            <label for="tableRows">Rows</label><br>
            <input type="number" name="tableRows" id="tableRows" min="0" max="16" required>
        </p>
        <p>
            <label for="tableColumns">Columns</label><br>
            <input type="number" name="tableColumns" id="tableColumns" min="0" max="16" required>
        </p>

        <p>
            <input type="reset" value="Reset">
            <input type="submit" value="Create Table">
        </p>
    </form>

    <hr>

    <!-- table result -->
    <h2>Table Result</h2>
    <%
        // get parameters
        String tableRowsParam = request.getParameter("tableRows");
        String tableColumnsParam = request.getParameter("tableColumns");

        if (tableRowsParam != null && tableColumnsParam != null) {
            int tableRows = Integer.parseInt(tableRowsParam);
            int tableColumns = Integer.parseInt(tableColumnsParam);

            // create an array of color codes
            String[] colorArray = {"00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "AA", "BB", "CC", "DD", "EE", "FF"};
    %>

    <table style="border: 0px;">
        <% for (int row = 1; row <= tableRows; row++) { %>
        <tr>
            <%
                for (int col = 1; col <= tableColumns; col++) {
                    String background = "AA" + colorArray[row - 1] + colorArray[col - 1];
            %>
            <td style="background-color: <%=background%>">R<%=row%>, C<%=col%>
            </td>
            <% } %>
        </tr>
        <% } %>
    </table>
    <% } %>
</div>
</body>
</html>
