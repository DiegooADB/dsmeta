import logo from "../../assets/img/logo.svg"

import "./styles.css"

function Header() {
    return (
        <header>
            <div className="dsmeta-log-container">
                <img src={logo} alt="DSMeta"></img>
                <h1>Dsmeta</h1>
                <p>
                    Desenvolvido por
                    <a href="https://www.youtube.com/watch?v=YBS8rJvxnKo"> Hamood</a>
                </p>
            </div>
        </header>
    )
}

export default Header;