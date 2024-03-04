<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sports Club Altenstadt - Create Account</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <meta name="description" content="Sports Club Altenstadt">
    <meta name="keywords" content="sports, tennis, football, altenstadt, austria, register, create account">
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
            <h1><a class="logo" href="../index.jsp"><img alt="Logo" src="./images/logo.png"></a></h1>
            <ul class="list-unstyled components mb-5">
                <li>
                    <a href="../index.jsp"><span class="fa fa-home mr-3"></span> Home</a>
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
                        <li>
                            <a href="Controller?dispatchto=MashupView">Mashup (OSM)</a>
                        </li>
                    </ul>
                </li>
                <li class="active">
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
        <h2 class="mb-4">Create Account</h2>

        <!-- registration form -->
        <form name="register" action="Controller" onsubmit="return validateForm()">
            <h4>Personal Data</h4>
            <div class="form-row">
                <div class="form-group col-md-5">
                    <label for="firstName">First Name</label>
                    <input type="text" class="form-control" name="firstName" id="firstName">
                </div>
                <div class="form-group col-md-5">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" name="lastName" id="lastName">
                </div>
                <div class="form-group col-md-2">
                    <span>Gender</span><br>
                    <p>
                        <div class="form-check form-check-inline">
                            <input type="radio" class="form-check-input" name="gender" id="male" value="male" checked>
                            <label for="male" class="form-check-label">Male</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input type="radio" class="form-check-input" name="gender" id="female" value="female">
                            <label for="female" class="form-check-label">Female</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input type="radio" class="form-check-input" name="gender" id="diverse" value="diverse">
                            <label for="diverse" class="form-check-label">Diverse</label>
                        </div>
                    </p>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" name="address" id="address">
                </div>
                <div class="form-group col-md-4">
                    <label for="country">Country</label>
                    <select id="country" name="country" class="form-control">
                        <option value="austria" selected>Austria</option>
                        <option value="germany">Germany</option>
                        <option value="switzerland">Switzerland</option>
                        <option value="other">Other</option>
                    </select>
                </div>
            </div>

            <hr>

            <!-- account data -->
            <h4>Account Data</h4>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="userID">User-ID</label><br>
                    <input type="text" class="form-control" name="userID" id="userID"/>
                </div>
                <div class="form-group col-md-6">
                    <label for="email">Email</label><br>
                    <input type="text" class="form-control" name="email" id="email"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="password">Password</label><br>
                    <input type="password" class="form-control" name="password" id="password"/>
                </div>
                <div class="form-group col-md-6">
                    <label for="confirmPassword">Confirm Password</label><br>
                    <input type="password" class="form-control" name="confirmPassword" id="confirmPassword"/>
                </div>
            </div>

            <hr>

            <!-- additionals -->
            <h4>Additionals</h4>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="department">Department</label>
                    <select id="department" name="department" class="form-control" multiple size="2">
                        <option value="austria" selected>Tennis</option>
                        <option value="germany">Football</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <span>Permissions</span><br>
                    <p>
                        <div class="form-check form-check-inline">
                            <input type="checkbox" class="form-check-input" name="permission" id="athlete" value="athlete" checked>
                            <label for="athlete" class="form-check-label">Athlete</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input type="checkbox" class="form-check-input" name="permission" id="departmentHead" value="departmentHead">
                            <label for="departmentHead" class="form-check-label">Department Head</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input type="checkbox" class="form-check-input" name="permission" id="admin" value="admin">
                            <label for="admin" class="form-check-label">Admin</label>
                        </div>
                    </p>
                </div>
            </div>

            <input type="hidden" name="dispatchto" value="CreateAccount">
            <button type="reset" class="btn btn-light">Reset</button>
            <button type="sumbit" class="btn btn-primary">Create Account</button>
        </form>
    </div>
</div>


<!-- JS -->
<script src="./js/jquery-3.6.0.min.js"></script>
<script src="./js/popper.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/main.js"></script>
<script src="./js/imagepopup.js"></script>
<script src="./js/cookies.js"></script>
<script src="./js/validation.js"></script>

</body>
</html>
