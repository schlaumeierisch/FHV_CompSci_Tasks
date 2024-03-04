<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>Sports Club Altenstadt - Login - Success</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <meta name="description" content="Sports Club Altenstadt">
    <meta name="keywords" content="sports, tennis, football, altenstadt, austria, login">
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

    <!-- page content -->
    <div class="p-4 p-md-5 pt-5" id="content">
        <h2 class="mb-4">Login Message</h2>

        <div class="card text-white bg-success">
            <div class="card-header">Success</div>
            <div class="card-body">
                <h5 class="card-title">Welcome back, ${sessionScope.login.userID}!</h5>
                <p class="card-text">
                    Your login was successful.<br>
                    Now you have access to the subpages.
                </p>
            </div>
            <div class="card-footer bg-transparent border-success">
                <a href="index.jsp" class="btn btn-primary btn-sm">Back to Home</a>
            </div>
        </div>
    </div>
</div>


<!-- JS -->
<script src="./js/jquery-3.6.0.min.js"></script>
<script src="./js/popper.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/main.js"></script>
</body>
</html>
