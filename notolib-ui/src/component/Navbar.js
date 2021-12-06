import React from 'react'


const Navbar=()=>{
    return (
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Notolib</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Accueil <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/apropos">A propos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/mybookings">Mes rendez-vous</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/notifications">Alertes</a>
                    </li>
                </ul>
            </div>
        </nav>
    )
}
export default Navbar;