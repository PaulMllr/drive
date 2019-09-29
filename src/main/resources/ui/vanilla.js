const cars = [
    {
        name: 'BMW M3',
        year: 2015,
        img: 'https://images.unsplash.com/photo-1523676060187-f55189a71f5e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80'
    },
    {
        name: 'Porshe cayene',
        year: 2013,
        img: 'https://images.pexels.com/photos/210019/pexels-photo-210019.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'
    },
    {
        name: 'Audi R8',
        year: 2016,
        img: 'https://images.pexels.com/photos/112460/pexels-photo-112460.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'
    },
    {
        name: 'BMW M2',
        year: 2011,
        img: 'https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/body-image/public/911-road-3629a.jpg?itok=m6x23Go0'
    }
]

function createCar(carDto) {
    return `
        <div class="card">
        <div class="card-img">
            <img src="${carDto.img}" alt="${carDto.name}">
            <h3>${carDto.name}</h3>
            <p>${carDto.year}</p>
        </div>
    </div>
    `
}


const snippets = cars.map(dto => createCar(dto))
const html = snippets.join(" ")

document.querySelector(".list").innerHTML = html
