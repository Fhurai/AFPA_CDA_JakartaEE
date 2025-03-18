/**
 * Generates the DOM structure for the page.
 */
function genDOM() {
    genHeader(document.body);
    generatePageContent(document.body, getCurrentPage());
    genFooter(document.body);
}

/**
 * Generates the content of the page based on the current page.
 * @param {HTMLElement} root - The root element to append the content to.
 * @param {string} currentPage - The current page identifier.
 */
function generatePageContent(root, currentPage) {
    console.log(currentPage);
    switch (currentPage) {
        case "index":
            genIndex(root);
            break;
        case "contact":
            genContact(root);
            break;
        case "connexion":
            genConnexion(root);
            break;
        case "deconnexion":
            genDeconnexion(root);
            break;
        case "clients":
        case "prospects":
            genSocieteIndex(root);
            break;
        case "clients/view":
        case "prospects/view":
            genSocieteView(root);
            break;
        case "clients/add":
        case "prospects/add":
            genSocieteCreate(root);
            break;
        case "clients/update":
        case "prospects/update":
            genSocieteUpdate(root);
            break;
        case "clients/delete":
        case "prospects/delete":
            genSocieteDelete(root);
            break;
        default:
            genErreur(root);
            console.error("Page non reconnue !");
    }
}

/**
 * Generates the header section of the page.
 * @param {HTMLElement} root - The root element to append the header to.
 */
function genHeader(root) {
    const header = createElementWithClass("header", "header");
    root.appendChild(header);

    const nav = createElementWithClass("nav", "navbar navbar-expand-lg fixed-top");
    header.appendChild(nav);

    const containerFluid = createElementWithClass("div", "container-fluid");
    nav.appendChild(containerFluid);

    const titleLink = createLink("./?cmd=index", "navbar-brand", "Reverso");
    containerFluid.appendChild(titleLink);

    const navbarToggler = createButton("navbar-toggler", "navbar-toggler", "button", "#offcanvasNavbar", "offcanvas", "<span class=\"navbar-toggler-icon\"></span>");
    containerFluid.appendChild(navbarToggler);

    const offcanvas = createElementWithClass("div", "offcanvas offcanvas-end");
    offcanvas.id = "offcanvasNavbar";
    offcanvas.tabIndex = "-1";
    nav.appendChild(offcanvas);

    const offcanvasHeader = createElementWithClass("div", "offcanvas-header");
    offcanvas.appendChild(offcanvasHeader);

    const offcanvasTitle = createElementWithClass("h5", "offcanvas-title");
    offcanvasTitle.id = "offcanvasNavbarLabel";
    offcanvasTitle.textContent = "Reverso";
    offcanvasHeader.appendChild(offcanvasTitle);

    const btnClose = createButton("btn-close", "Close", "button", "", "offcanvas", "");
    offcanvasHeader.appendChild(btnClose);

    const offcanvasBody = createElementWithClass("div", "offcanvas-body");
    offcanvas.appendChild(offcanvasBody);

    const centerList = createElementWithClass("ul", "navbar-nav justify-content-end flex-grow-1 pe-3");
    offcanvasBody.appendChild(centerList);

    const navItems = [
        {
            label: "Page d'accueil",
            href: "./?cmd=index",
            icon: "home",
            text: "Accueil"
        },
        {
            label: "Partie Clients",
            href: "./?cmd=clients",
            icon: "contact_page",
            text: "Clients"
        },
        {
            label: "Partie Prospects",
            href: "./?cmd=prospects",
            icon: "perm_contact_calendar",
            text: "Prospects"
        },
    ];

    navItems.forEach(item => {
        centerList.appendChild(createNavItem(item.label, "nav-item", item.href, "nav-link active", `<div class="material-symbols-outlined">${item.icon}</div><div>${item.text}</div>`));
    });

    const hr = document.createElement("hr");
    offcanvasBody.appendChild(hr);

    const endList = createElementWithClass("ul", "navbar-nav justify-content-end flex-grow-1 pe-3");
    offcanvasBody.appendChild(endList);

    endList.appendChild(createNavItem("Page de connexion", "nav-item", "./?cmd=connexion", "nav-link active", "<div class=\"material-symbols-outlined\">login</div><div>Connexion</div>"));
    endList.appendChild(createNavItem("Page de déconnexion", "nav-item", "./?cmd=deconnexion", "nav-link active", "<div class=\"material-symbols-outlined\">logout</div><div>Déconnexion</div>"));
}

/**
 * Generates the footer section of the page.
 * @param {HTMLElement} root - The root element to append the footer to.
 */
function genFooter(root) {
    const footer = createElementWithClass("footer", "footer");
    root.appendChild(footer);

    const containerFluid = createElementWithClass("div", "container-fluid");
    footer.appendChild(containerFluid);

    const row = createElementWithClass("div", "row");
    containerFluid.appendChild(row);

    row.appendChild(createFooterContainer("col-4", "Done with <a href='https://getbootstrap.com'>Bootstrap</a>"));
    row.appendChild(createFooterContainer("col-4", "<a href='./?cmd=contact'>Nous contacter</a>"));
    row.appendChild(createFooterContainer("col-4", "<a href='./sitemap.xml'>Plan du site</a>"));
}

/**
 * Creates an element with a specified class.
 * @param {string} tag - The tag name of the element.
 * @param {string} className - The class name to assign to the element.
 * @returns {HTMLElement} The created element.
 */
function createElementWithClass(tag, className) {
    const element = document.createElement(tag);
    element.classList = className;
    return element;
}

/**
 * Creates a link element.
 * @param {string} href - The href attribute of the link.
 * @param {string} className - The class name to assign to the link.
 * @param {string} textContent - The text content of the link.
 * @returns {HTMLAnchorElement} The created link element.
 */
function createLink(href, className, textContent) {
    const link = document.createElement("a");
    link.classList = className;
    link.href = href;
    link.textContent = textContent;
    return link;
}

/**
 * Creates a button element.
 * @param {string} className - The class name to assign to the button.
 * @param {string} ariaLabel - The aria-label attribute of the button.
 * @param {string} type - The type attribute of the button.
 * @param {string} bsTarget - The data-bs-target attribute of the button.
 * @param {string} bsToggle - The data-bs-toggle attribute of the button.
 * @param {string} innerHTML - The inner HTML content of the button.
 * @returns {HTMLButtonElement} The created button element.
 */
function createButton(className, ariaLabel, type, bsTarget, bsToggle, innerHTML) {
    const button = document.createElement("button");
    button.classList = className;
    button.ariaLabel = ariaLabel;
    button.type = type;
    if (bsTarget) button.dataset.bsTarget = bsTarget;
    if (bsToggle) button.dataset.bsToggle = bsToggle;
    button.innerHTML = innerHTML;
    return button;
}

/**
 * Creates a navigation item element.
 * @param {string} ariaLabel - The aria-label attribute of the item.
 * @param {string} className - The class name to assign to the item.
 * @param {string} href - The href attribute of the link inside the item.
 * @param {string} linkClass - The class name to assign to the link inside the item.
 * @param {string} innerHTML - The inner HTML content of the link inside the item.
 * @returns {HTMLLIElement} The created navigation item element.
 */
function createNavItem(ariaLabel, className, href, linkClass, innerHTML) {
    const item = document.createElement("li");
    item.ariaLabel = ariaLabel;
    item.classList = className;

    const link = document.createElement("a");
    link.classList = linkClass;
    link.href = href;
    link.innerHTML = innerHTML;

    item.appendChild(link);
    return item;
}

/**
 * Creates a footer container element.
 * @param {string} className - The class name to assign to the container.
 * @param {string} innerHTML - The inner HTML content of the container.
 * @returns {HTMLDivElement} The created footer container element.
 */
function createFooterContainer(className, innerHTML) {
    const container = document.createElement("div");
    container.classList = className;
    container.innerHTML = innerHTML;
    return container;
}