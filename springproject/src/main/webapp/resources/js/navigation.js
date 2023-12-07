function editAccount() {
  var editAccountModal = document.getElementById("editAccountModal");
  editAccountModal.style.display =
    editAccountModal.style.display === "block" ? "none" : "block";
}

document.getElementById("nav-close-button").addEventListener("click", () => {
  var editAccountModal = document.getElementById("editAccountModal");
  editAccountModal.style.display = "none";
});

function toggleSearch() {
  var searchIcon = document.getElementById("search");
  var searchInput = document.getElementById("searchInput");
  var searchField = document.getElementById("searchField");

  searchIcon.style.display = "none";
  searchInput.style.display = "block";
  searchField.focus();
}

function cancelSearch() {
  var searchIcon = document.getElementById("search");
  var searchInput = document.getElementById("searchInput");

  searchInput.style.display = "none";
  searchIcon.style.display = "block";
}