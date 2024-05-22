import React, { useState } from 'react';
import Select from 'react-select';
import countryData from '../data/paises.json';
import cityData from '../data/ciudades.json';
import departmentData from '../data/departamentos.json';

const Cities = () => {
    const [selectedCountry, setSelectedCountry] = useState(null);
    const [selectedCity, setSelectedCity] = useState(null);
    const [selectedDepartment, setSelectedDepartment] = useState(null);

    const handleCountryChange = (selectedOption) => {
        setSelectedCountry(selectedOption);
        setSelectedCity(null); // Reset city and department when country changes
        setSelectedDepartment(null);
    };

    const handleCityChange = (selectedOption) => {
        setSelectedCity(selectedOption);
        setSelectedDepartment(null); // Reset department when city changes
    };

    const handleDepartmentChange = (selectedOption) => {
        setSelectedDepartment(selectedOption);
    };

    const getCities = () => {
        if (!selectedCountry) return [];
        return cityData.filter(city => city.countryId === selectedCountry.value);
    };

    const getDepartments = () => {
        if (!selectedCity) return [];
        return departmentData.filter(department => department.cityId === selectedCity.value);
    };

    return (
        <div>
            <div>
                <label>País:</label>
                <Select
                    options={countryData}
                    value={selectedCountry}
                    onChange={handleCountryChange}
                />
            </div>
            <div>
                <label>Ciudad:</label>
                <Select
                    options={getCities()}
                    value={selectedCity}
                    onChange={handleCityChange}
                    isDisabled={!selectedCountry}
                />
            </div>
            <div>
                <label>Departamento:</label>
                <Select
                    options={getDepartments()}
                    value={selectedDepartment}
                    onChange={handleDepartmentChange}
                    isDisabled={!selectedCity}
                />
            </div>
        </div>
    );
};

export default Cities;
