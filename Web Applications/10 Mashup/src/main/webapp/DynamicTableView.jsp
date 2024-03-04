<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>Sports Club Altenstadt - Fun Pages: Dynamic Table</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <meta content="Sports Club Altenstadt" name="description">
    <meta content="sports, tennis, football, altenstadt, austria, fun pages, funpages, dynamic table, dynamictable"
          name="keywords">
    <meta content="Matthias Meier" name="author">

    <!-- FONT -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">

    <!-- CSS -->
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="./css/style.css" rel="stylesheet">
</head>

<body>
<div class="wrapper d-flex align-items-stretch">
    <!-- navigation bar -->
    <nav class="active" id="sidebar">
        <div class="custom-menu">
            <button class="btn btn-primary" id="sidebarCollapse" type="button">
                <i class="fa fa-bars"></i>
                <span class="sr-only">Toggle Menu</span>
            </button>
        </div>
        <div class="p-4">
            <h1><a class="logo" href="index.jsp"><img alt="Logo" src="./images/logo.png"></a></h1>
            <ul class="list-unstyled components mb-5">
                <li>
                    <a href="index.jsp"><span class="fa fa-home mr-3"></span> Home</a>
                </li>
                <li>
                    <a aria-expanded="false" class="dropdown-toggle" data-toggle="collapse" href="#pageSubmenu">
                        <span class="fa fa-building mr-3"></span> Departments
                    </a>
                    <ul class="collapse list-unstyled" id="pageSubmenu">
                        <li>
                            <a href="Controller?dispatchto=TCAltenstadtView">TC Altenstadt</a>
                        </li>
                        <li>
                            <a href="Controller?dispatchto=TSVAltenstadtView">TSV Altenstadt</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="guestbook"><span class="fa fa-book mr-3"></span> Guestbook</a>
                </li>
                <li class="active">
                    <a aria-expanded="false" class="dropdown-toggle" data-toggle="collapse" href="#testingSubmenu">
                        <span class="fa fa-star mr-3"></span> Fun Pages
                    </a>
                    <ul class="collapse list-unstyled show" id="testingSubmenu">
                        <li class="active">
                            <a href="Controller?dispatchto=DynamicTableView">Dynamic Table</a>
                        </li>
                        <li>
                            <a href="Controller?dispatchto=MashupView">Mashup (OSM)</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="Controller?dispatchto=CreateAccountView"><span class="fa fa-user mr-3"></span> Create Account</a>
                </li>
                <li>
                    <a href="mailto: matthias.meier@students.fhv.at"><span class="fa fa-paper-plane mr-3"></span>
                        Contact</a>
                </li>
            </ul>

            <div class="footer">
                <p>
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                    Matthias Meier
                </p>
            </div>
        </div>
    </nav>

    <!-- page content  -->
    <div class="p-4 p-md-5 pt-5" id="content">
        <h2 class="mb-4">Dynamic Table</h2>

        <!-- table settings form -->
        <div class="row">
            <div class="col">
                <h4>Table Settings</h4>
                <form class="col-md-2" name="dynamicTable" action="DynamicTableView.jsp">
                    <div class="form-group">
                        <label for="tableRows">Rows</label>
                        <input type="number" class="form-control" name="tableRows" id="tableRows" min="0" max="16" required>
                    </div>
                    <div class="form-group">
                        <label for="tableColumns">Columns</label>
                        <input type="number" class="form-control" name="tableColumns" id="tableColumns" min="0" max="16" required>
                    </div>

                    <button type="reset" class="btn btn-light">Reset</button>
                    <button type="submit" class="btn btn-primary">Create Table</button>
                </form>
            </div>
        </div>

        <hr>

        <!-- table result -->
        <div class="row">
            <div class="col">
                <h4>Table Result</h4>
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

                <table>
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
        </div>
    </div>
</div>

<!-- JS -->
<script src="./js/jquery-3.6.0.min.js"></script>
<script src="./js/popper.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/main.js"></script>
<script src="./js/cookies.js"></script>
</body>
</html>
