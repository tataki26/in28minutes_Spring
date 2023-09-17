const person = {
    name: 'Ranga Karanam',
    // object
    address: { 
        line1: 'Baker Street',
        city: 'London',
        country: 'UK',
    },
    // array
    profiles: ['twitter', 'linkdin', 'instagram'],
    // function
    printProfile: () => {
        person.profiles.map(
            profile => console.log(profile)
        )
        console.log(person.profiles[1]);
    }
}

export default function LearningJavaScript() {
    return (
        <>
            <div>{person.name}</div>
            <div>{person.address.line1}</div>
            <div>{person.profiles[2]}</div>
            <div>{person.printProfile()}</div>
        </>
    )
}
