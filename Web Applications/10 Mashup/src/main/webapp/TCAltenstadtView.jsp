<!doctype html>
<html lang="en">
<head>
    <title>Sports Club Altenstadt - TC Altenstadt</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <meta name="description" content="Sports Club Altenstadt">
    <meta name="keywords" content="sports, tennis, football, altenstadt, austria, tc altenstadt, tcaltenstadt, tennis">
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
            <h1><a class="logo" href="index.jsp"><img alt="Logo" src="./images/logo.png"></a></h1>
            <ul class="list-unstyled components mb-5">
                <li>
                    <a href="index.jsp"><span class="fa fa-home mr-3"></span> Home</a>
                </li>
                <li class="active">
                    <a aria-expanded="false" class="dropdown-toggle" data-toggle="collapse" href="#pageSubmenu">
                        <span class="fa fa-building mr-3"></span> Departments
                    </a>
                    <ul class="collapse list-unstyled show" id="pageSubmenu">
                        <li class="active">
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
        <h2 class="mb-4">TC Altenstadt (Season 2021)</h2>

        <!-- description -->
        <div class="row">
            <div class="col">
                <h4>Description</h4>
                <p>
                    Tennis players of any level can play with us at any time. At our facility there are also tennis
                    coaches with whom you can easily make appointments and thus improve your performance. In addition to
                    the sports aspect, we have an excellent restaurant where you can relax very well. You can also cheer
                    on our professional team as they play in the summer. This team is currently playing in the
                    Bundesliga and competes with the best players in Austria.
                </p>
            </div>
        </div>

        <hr>

        <!-- sports director -->
        <div class="row">
            <div class="col">
                <h4>Sports Director</h4>
                <table>
                    <tr>
                        <td colspan="2"><img alt="Herbert Allgäuer" height="150" src="./images/tcapresident.jpg"></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td>Herbert Allgäuer</td>
                    </tr>
                    <tr>
                        <td>E-Mail:</td>
                        <td><a href="mailto: herbert.a@lampertmail.at">herbert.a@lampertmail.at</a></td>
                    </tr>
                </table>
            </div>
        </div>

        <hr>

        <!-- results and upcoming matches -->
        <div class="row">
            <div class="col">
                <h4>Results and Upcoming Matches</h4>
                <table>
                    <tr>
                        <th>Date</th>
                        <th>Opponents</th>
                        <th>Home/Away</th>
                        <th>Scores</th>
                    </tr>
                    <tr>
                        <td>29.05.2021</td>
                        <td>TC Kern</td>
                        <td>Away</td>
                        <td>3:6</td>
                    </tr>
                    <tr>
                        <td>03.06.2021</td>
                        <td>UTC Casa Moda Steyr 1</td>
                        <td>Home</td>
                        <td>3:6</td>
                    </tr>
                    <tr>
                        <td>05.06.2021</td>
                        <td>TC Raiffeisen Schwaz 1</td>
                        <td>Away</td>
                        <td>7:2</td>
                    </tr>
                    <tr>
                        <td>12.06.2021</td>
                        <td>TC Raiffeisen Dornbirn 1</td>
                        <td>Home</td>
                        <td>3:6</td>
                    </tr>
                    <tr>
                        <td>19.06.2021</td>
                        <td>Union Stein&Co Mauthausen 1</td>
                        <td>Home</td>
                        <td>2:7</td>
                    </tr>
                    <tr>
                        <td>26.06.2021</td>
                        <td>TC Telfs 1</td>
                        <td>Home</td>
                        <td>7:2</td>
                    </tr>
                </table>
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