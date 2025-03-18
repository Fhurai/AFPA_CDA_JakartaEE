<header class="header">
    <nav class="navbar navbar-expand-lg fixed-top">
        <div class="container-fluid"><a class="navbar-brand"
                                        href="./index">Reverso</a>
            <button class="navbar-toggler" aria-label="navbar-toggler"
                    type="button" data-bs-target="#offcanvasNavbar"
                    data-bs-toggle="offcanvas"><span
                    class="navbar-toggler-icon"></span></button>
        </div>
        <div class="offcanvas offcanvas-end" id="offcanvasNavbar" tabindex="-1">
            <div class="offcanvas-header"><h5 class="offcanvas-title"
                                              id="offcanvasNavbarLabel">
                Reverso</h5>
                <button class="btn-close" aria-label="Close" type="button"
                        data-bs-toggle="offcanvas"></button>
            </div>
            <div class="offcanvas-body">
                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                    <li aria-label="Page d'accueil" class="nav-item"><a
                            class="nav-link active" href="?cmd=index">
                        <div class="material-symbols-outlined">home</div>
                        <div>Accueil</div>
                    </a></li>
                    <li aria-label="Partie Clients" class="nav-item"><a
                            class="nav-link active" href="?cmd=clients">
                        <div class="material-symbols-outlined">contact_page
                        </div>
                        <div>Clients</div>
                    </a></li>
                    <li aria-label="Partie Prospects" class="nav-item"><a
                            class="nav-link active"
                            href="?cmd=prospects">
                        <div class="material-symbols-outlined">
                            perm_contact_calendar
                        </div>
                        <div>Prospects</div>
                    </a></li>
                </ul>
                <hr>
                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                    <li aria-label="Page de connexion" class="nav-item"><a
                            class="nav-link active" href="?cmd=connexion">
                        <div class="material-symbols-outlined">login</div>
                        <div>Connexion</div>
                    </a></li>
                    <li aria-label="Page de déconnexion" class="nav-item"><a
                            class="nav-link active" href="?cmd=deconnexion">
                        <div class="material-symbols-outlined">logout</div>
                        <div>Deconnexion</div>
                    </a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>