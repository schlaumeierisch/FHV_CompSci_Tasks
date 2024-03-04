<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>Sports Club Altenstadt - Home</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <meta name="description" content="Sports Club Altenstadt">
    <meta name="keywords" content="sports, tennis, football, altenstadt, austria, overview, home">
    <meta name="author" content="Matthias Meier">

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
            <h1><a class="logo" href="Controller?dispatchto=HomeView"><img alt="Logo" src="./images/logo.png"></a></h1>
            <ul class="list-unstyled components mb-5">
                <li class="active">
                    <a href="Controller?dispatchto=HomeView"><span class="fa fa-home mr-3"></span> Home</a>
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
                <li>
                    <a aria-expanded="false" class="dropdown-toggle" data-toggle="collapse" href="#testingSubmenu">
                        <span class="fa fa-star mr-3"></span> Fun Pages
                    </a>
                    <ul class="collapse list-unstyled" id="testingSubmenu">
                        <li>
                            <a href="Controller?dispatchto=DynamicTableView">Dynamic Table</a>
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
        <h2 class="mb-4">Home</h2>

        <div class="row">
            <!-- sports departments -->
            <div class="col">
                <h4>Sports Departments</h4>
                <ul>
                    <li><a href="Controller?dispatchto=TCAltenstadtView">TC Altenstadt</a>
                        <ul>
                            <li>Sport: Tennis</li>
                            <li>Address: Beim Mühlbach 40, 6800 Feldkirch</li>
                        </ul>
                    </li>
                    <li><a href="Controller?dispatchto=TSVAltenstadtView">TSV Altenstadt</a>
                        <ul>
                            <li>Sport: Football</li>
                            <li>Address: Tafernstraße 64, 6800 Feldkirch</li>
                        </ul>
                    </li>
                </ul>
            </div>

            <!-- members -->
            <div class="col">
                <h4>Club Members</h4>
                <table>
                    <tr>
                        <th>Departments</th>
                        <th>Members</th>
                        <th>Total</th>
                    </tr>
                    <tr>
                        <td>TSV Altenstadt</td>
                        <td>500</td>
                        <td rowspan="2">700</td>
                    </tr>
                    <tr>
                        <td>TC Altenstadt</td>
                        <td>200</td>
                    </tr>
                </table>
            </div>

            <!-- get to know us -->
            <div class="col">
                <h4>Get to Know Us</h4>
                Here you can see a picture of the TSV Altenstadt men's team:<br>
                <button type="button" class="btn btn-primary btn-sm" onclick="openWindow('./images/tsvmenteam.jpg')">
                    Click Here
                </button>
            </div>
        </div>

        <hr>

        <div class="row">
            <!-- register -->
            <div class="col">
                <h4>Register Now</h4>
                <p>
                    Could we make you curious?<br>
                    Then create a free account now: <a href="Controller?dispatchto=CreateAccountView">Create Account</a>
                </p>
            </div>
        </div>
    </div>
</div>
</div>

<!-- JS -->
<script src="./js/jquery.min.js"></script>
<script src="./js/popper.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/main.js"></script>
<script src="./js/imagepopup.js"></script>
<script src="./js/cookies.js"></script>
</body>
</html>