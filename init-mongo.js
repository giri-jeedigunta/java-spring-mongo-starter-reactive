db.createUser({
    user: "giri",
    pwd: "spring2020",
    roles:[
        {role: "dbAdmin", db:"api"}
    ]
})