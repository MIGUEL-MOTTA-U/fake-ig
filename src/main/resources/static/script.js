function toggleDropdown() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function selectLanguage(language) {
    document.querySelector('.drop-btn').textContent = language + ' ▼';
    document.getElementById("myDropdown").classList.remove("show");
}

    // Close dropdown if clicked outside
window.onclick = function(event) {
    if (!event.target.matches('.drop-btn')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        for (var i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}
