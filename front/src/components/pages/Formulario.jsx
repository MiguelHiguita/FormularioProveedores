import { useForm } from 'react-hook-form';
import React, { useState, useEffect } from 'react';
import Select from 'react-select';
import countryData from '../data/paises.json';
import cityData from '../data/ciudades.json';
import departmentData from '../data/departamentos.json';

const Formulario = () => {
    const { register, formState: { errors }, handleSubmit, setValue, trigger } = useForm();
    const onSubmit = (data) => { console.log(data) };
    const [selectedCountry, setSelectedCountry] = useState(null);
    const [selectedCity, setSelectedCity] = useState(null);
    const [selectedDepartment, setSelectedDepartment] = useState(null);

    useEffect(() => {
        register('pais', { required: 'Este campo es obligatorio' });
        register('ciudad', { required: 'Este campo es obligatorio' });
        register('departamento', { required: 'Este campo es obligatorio' });
    }, [register]);

    const handleCountryChange = (selectedOption) => {
        setSelectedCountry(selectedOption);
        setValue('pais', selectedOption?.label);
        setSelectedCity(null);
        setValue('ciudad', null);
        setSelectedDepartment(null);
        setValue('departamento', null);
        trigger('pais');
        trigger('ciudad');
        trigger('departamento');
    };

    const handleCityChange = (selectedOption) => {
        setSelectedCity(selectedOption);
        setValue('ciudad', selectedOption?.label);
        setSelectedDepartment(null);
        setValue('departamento', null);
        trigger('ciudad');
        trigger('departamento');
    };

    const handleDepartmentChange = (selectedOption) => {
        setSelectedDepartment(selectedOption);
        setValue('departamento', selectedOption?.label);
        trigger('departamento');
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
            <h2>Formulario</h2>
            <form onSubmit={handleSubmit(onSubmit)}>
                <div>
                    <label>Nombre: </label>
                    <input type="text" {...register('nombre', {
                        required: 'Este campo es obligatorio',
                        maxLength: { value: 40, message: 'El nombre es demasiado largo' },
                        pattern: { value: /^[a-zA-Z ]+$/, message: 'El nombre solo puede contener letras' }
                    })} />
                    {errors.nombre && <p>{errors.nombre.message}</p>}
                </div>
                <div>
                    <label>Documento de identificación: </label>
                    <input type="text" {...register('documentoID', { 
                        required: 'Este campo es obligatorio',
                        maxLength: { value: 11, message: 'El documento es demasiado largo'},
                        minLength: { value: 9, message: 'El documento debe tener minimo 9 caracteres'},
                        pattern: { value: /^[0-9]+$/, message: 'El formato es incorrecto'
                            
                        } })} />
                    {errors.documentoID && <p>{errors.documentoID.message}</p>}
                </div>
                <div>
                    <label>Nombre del representante legal: </label>
                    <input type="text" {...register('nombreRepresentante', {
                        required: 'Este campo es obligatorio',
                        maxLength: { value: 40, message: 'El nombre es demasiado largo' },
                        pattern: { value: /^[a-zA-Z ]+$/, message: 'El nombre solo puede contener letras' }
                    })} />
                    {errors.nombreRepresentante && <p>{errors.nombreRepresentante.message}</p>}
                </div>
                <div>
                    <label>Teléfono de contacto: </label>
                    <input type="text" {...register('telefono', {
                        required: 'Este campo es obligatorio',
                        maxLength: { value: 10, message: 'El número de teléfono es demasiado largo' },
                        minLength: { value: 10, message: 'El número de teléfono debe contener 10 dígitos' },
                        pattern: { value: /^[0-9]+$/, message: 'El formato es incorrecto' }
                    })} />
                    {errors.telefono && <p>{errors.telefono.message}</p>}
                </div>
                <div>
                    <label>Email de contacto: </label>
                    <input type="email" {...register('email', {
                        required: 'Este campo es obligatorio',
                        pattern: { value: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/, message: 'El formato es incorrecto' }
                    })} />
                    {errors.email && <p>{errors.email.message}</p>}
                </div>
                <div>
                    <label>Dirección: </label>
                    <input type="text" {...register('direccion', { required: 'Este campo es obligatorio' })} />
                    {errors.direccion && <p>{errors.direccion.message}</p>}
                </div>
                <div>
                    <label>Personería Jurídica: </label>
                    <select {...register('personeria', { required: 'Este campo es obligatorio' })}>
                        <option value="Natural">Natural</option>
                        <option value="Jurídica">Jurídica</option>
                    </select>
                    {errors.personeria && <p>{errors.personeria.message}</p>}
                </div>
                <div>
                    <label>País: </label>
                    <Select
                        options={countryData}
                        value={selectedCountry}
                        onChange={handleCountryChange}
                        isClearable
                    />
                    {errors.pais && <p>{errors.pais.message}</p>}
                </div>
                <div>
                    <label>Ciudad:</label>
                    <Select
                        options={getCities()}
                        value={selectedCity}
                        onChange={handleCityChange}
                        isDisabled={!selectedCountry}
                        isClearable
                    />
                    {errors.ciudad && <p>{errors.ciudad.message}</p>}
                </div>
                <div>
                    <label>Departamento:</label>
                    <Select
                        options={getDepartments()}
                        value={selectedDepartment}
                        onChange={handleDepartmentChange}
                        isDisabled={!selectedCity}
                        isClearable
                    />
                    {errors.departamento && <p>{errors.departamento.message}</p>}
                </div>
                <input type="submit" value="Enviar" />
            </form>
        </div>
    );
};

export default Formulario;
