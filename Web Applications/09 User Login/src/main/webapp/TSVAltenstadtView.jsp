<!doctype html>
<html lang="en">
<head>
    <title>Sports Club Altenstadt - TC Altenstadt</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <meta content="Sports Club Altenstadt" name="description">
    <meta content="sports, tennis, football, altenstadt, austria, tsv altenstadt, tsvaltenstadt, football"
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
                <li class="active">
                    <a aria-expanded="false" class="dropdown-toggle" data-toggle="collapse" href="#pageSubmenu">
                        <span class="fa fa-building mr-3"></span> Departments
                    </a>
                    <ul class="collapse list-unstyled" id="pageSubmenu">
                        <li>
                            <a href="Controller?dispatchto=TCAltenstadtView">TC Altenstadt</a>
                        </li>
                        <li class="active">
                            <a href="Controller?dispatchto=TSVAltenstadtView">TSV Altenstadt</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="guestbook"><span class="fa fa-book mr-3"></span> Guestbook</a>
                </li>
                <li>
                    <a href="Controller?dispatchto=CreateAccountView"><span class="fa fa-user mr-3"></span> Create Account</a>
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
        <h2 class="mb-4">TSV Altenstadt (Season 2021/2022)</h2>

        <!-- description -->
        <div class="row">
            <div class="col">
                <h4>Description</h4>
                <p>
                    Every soccer enthusiast, no matter what age, will find a suitable place with us. We have numerous,
                    diverse teams and enjoy the sport. For people who like to watch matches more often, we also have
                    something great: Almost every second Saturday, our men's teams (1 and 1b) play on the soccer field
                    in Altenstadt. Here there is also enough beer and grilled sausages for everyone. Our first men's
                    football team is currently playing in the Vorarlberg Provincial League. In the beginning, the team
                    consisted mainly of people from Altenstadt, but now players from everywhere play with us.
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
                        <td colspan="2"><img alt="Wolfgang Oswald" height="150" src="./images/tsvpresident.png"></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td>Wolfgang Oswald</td>
                    </tr>
                    <tr>
                        <td>E-Mail:</td>
                        <td><a class="link-underline" href="mailto: wolfgangoswald@me.com">wolfgangoswald@me.com</a>
                        </td>
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
                        <td>02.10.2021</td>
                        <td>FC Sulz</td>
                        <td>Away</td>
                        <td>1:0</td>
                    </tr>
                    <tr>
                        <td>08.10.2021</td>
                        <td>FC Riefensberg</td>
                        <td>Away</td>
                        <td>2:3</td>
                    </tr>
                    <tr>
                        <td>24.10.2021</td>
                        <td>FC Sulzberg</td>
                        <td>Home</td>
                        <td>-</td>
                    </tr>
                    <tr>
                        <td>30.10.2021</td>
                        <td>FC Hittisau</td>
                        <td>Away</td>
                        <td>-</td>
                    </tr>
                </table>
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
<script src="./js/cookies.js"></script>
</body>
</html>