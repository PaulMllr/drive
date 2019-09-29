function Car(props) {

    const classes = ['card'];

    if (props.car.marked) {
        classes.push("marked");
    }
    return (
        <div className={classes.join(" ")} onClick={props.onMark}>
            <div className="card-img">
                <img src={props.car.img} alt={props.car.name}/>
                <h3>{props.car.name}</h3>
                <p>{props.car.year}</p>
            </div>
        </div>
    )
}

class App extends React.Component {

    state = {
        cars: [
            {
                marked: false,
                name: 'BMW M3',
                year: 2015,
                img: 'https://images.unsplash.com/photo-1523676060187-f55189a71f5e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80'
            },
            {
                marked: false,
                name: 'Porshe cayene',
                year: 2013,
                img: 'https://images.pexels.com/photos/210019/pexels-photo-210019.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'
            },
            {
                marked: false,
                name: 'Audi R8',
                year: 2016,
                img: 'https://images.pexels.com/photos/112460/pexels-photo-112460.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'
            },
            {
                marked: false,
                name: 'BMW M2',
                year: 2011,
                img: 'https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/body-image/public/911-road-3629a.jpg?itok=m6x23Go0'
            }
        ]
    };

    handleMarked(name) {
        const cars = this.state.cars.concat();
        const car = cars.find(it => it.name === name);
        car.marked = !car.marked

        this.setState({cars})
    }

    renderCars() {
        return this.state.cars.map(it => {
            return (<Car
                key={it.name}
                onMark={this.handleMarked.bind(this, it.name)}
                car={it}/>)
        })
    }

    render() {
        return (
            <div className="app">
                <div className="list">
                    {this.renderCars()}
                </div>
            </div>
        )
    }
}


ReactDOM.render(<App/>, document.getElementById('root'));