import React from "react";
import Footer from "../component/Footer";
import Navbar from "../component/Navbar";

const Apropos= () => {
    return (
        <div>
            <Navbar/>
            <main>
                <section className="herobooking py-10 min-h-40">
                    <div className="container max-w-4xl mx-auto px-4 h-full flex flex-col  gap-8">
                        <div className="text-center">
                            <h2 className="text-4xl font-extrabold max-w-prose mb-2 text-white italic">
                                Notolib
                            </h2>
                        </div>
                        <div className="relative">
                            <div className="rounded-lg pb-20 px-20 bg-gray-200 text-left bg-opacity-70 border shadow-2xl">
                                <div className="px-4 py-8 mb-4">
                                    <div>
                                        <h6 className="text-2xl text-left font-bold text-gray-600">
                                            A propos de Notolib
                                        </h6>
                                        <p className="text-lg ">
                                            Notolib est une application web qui propose un service de gestion en ligne des rendez-vous pour les notaires et un service de prise de rendez vous en ligne pour les utilisateurs.
                                        </p>
                                        <p className="text-lg ">
                                            Cette plateforme vous met en relation avec un notaire en vous offrant une expérience simple et de qualité.
                                        </p>
                                    </div>

                                </div>
                            </div>
                        </div >
                    </div >
                </section>

                <section className=" bg-gray-200 px-80 ">
                    <div className="container mx-auto max-w-4xl ">
                        <div className="grid md:grid-cols-3 gap-4 justify-center">
                            <div className="items-center">

                                <svg xmlns="http://www.w3.org/2000/svg"
                                     className="h-24 text-blue-700 mx-auto mb-2"
                                     viewBox="0 0 48 48"
                                     width="100px"
                                     height="100px">
                                    <path fill="#4caf50" d="M44,24c0,11.045-8.955,20-20,20S4,35.045,4,24S12.955,4,24,4S44,12.955,44,24z"/>
                                    <path fill="#ccff90" d="M34.602,14.602L21,28.199l-5.602-5.598l-2.797,2.797L21,33.801l16.398-16.402L34.602,14.602z"/>
                                </svg>
                                <div className="text-center">
                                    <h3 className="font-bold ">Qualité</h3>
                                    <p className="text-2x1 text-gray-600">
                                        Accédez aux disponnibilités de plusieurs notaires
                                    </p>
                                </div>
                            </div>

                            <div className="items-center">


                                <svg
                                    width="100px"
                                    height="100px"
                                    viewBox="0 0 72 72"
                                    id="emoji"
                                    xmlns="http://www.w3.org/2000/svg"
                                    className="h-24 text-blue-700 mx-auto mb-2">
                                    <g id="color">
                                        <path fill="#92d3f5" d="M59.0349,60h-46.07A.9679.9679,0,0,1,12,59.0349v-46.07A.9679.9679,0,0,1,12.9651,12h46.07A.9679.9679,0,0,1,60,12.9651v46.07A.9679.9679,0,0,1,59.0349,60Z"/>
                                    </g>
                                    <g id="line">
                                        <g id="FREE">
                                            <path fill="none" stroke="#000" stroke-linejoin="round" stroke-width="2" d="M59.0349,60h-46.07A.9679.9679,0,0,1,12,59.0349v-46.07A.9679.9679,0,0,1,12.9651,12h46.07A.9679.9679,0,0,1,60,12.9651v46.07A.9679.9679,0,0,1,59.0349,60Z"/>
                                            <polyline fill="none" stroke="#000" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" points="23.83 36.376 20.83 36.376 20.83 39.876 20.83 32.876 24.83 32.876"/>
                                            <g>
                                                <path fill="none" stroke="#000" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M29.0081,39.8759v-7h2.6692a1.7434,1.7434,0,0,1,1.7434,1.7435h0a1.7433,1.7433,0,0,1-1.7434,1.7434H29.0081"/>
                                                <line x1="31.6898" x2="33.207" y1="36.3628" y2="39.8759" fill="none" stroke="#000" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"/>
                                            </g>
                                            <g>
                                                <polyline fill="none" stroke="#000" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" points="42.83 32.876 38.83 32.876 38.83 39.876 42.83 39.876"/>
                                                <line x1="38.8296" x2="41.8296" y1="36.3759" y2="36.3759" fill="none" stroke="#000" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"/>
                                            </g>
                                            <g>
                                                <polyline fill="none" stroke="#000" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" points="51.83 32.876 47.83 32.876 47.83 39.876 51.83 39.876"/>
                                                <line x1="47.8296" x2="50.8296" y1="36.3759" y2="36.3759" fill="none" stroke="#000" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"/>
                                            </g>
                                        </g>
                                    </g>
                                </svg>

                                <div className="text-center">
                                    <h3 className="font-bold ">Gratuit</h3>
                                    <p className="text-2x1 text-gray-600">
                                        Une plateforme totalement gratuite
                                    </p>
                                </div>
                            </div>

                            <div className="items-center">
                                <svg
                                    className="h-24 text-blue-700 mx-auto mb-2"
                                    width="100px"
                                    height="100px"
                                    viewBox="0 0 512 512"
                                    xmlns="http://www.w3.org/2000/svg">
                                    <title/>
                                    <g data-name="24hours_7days"
                                       id="_24hours_7days">
                                        <path d="M456,248a7.9979,7.9979,0,0,0-8,8,192.0091,192.0091,0,1,1-71.436-149.4219H342.8281a8,8,0,0,0,0,16h54.5938a8.031,8.031,0,0,0,8-8V59.9844a8,8,0,1,0-16,0V96.4609a207.9878,207.9878,0,0,0-280.5,306.6172A208,208,0,0,0,464,256,7.9979,7.9979,0,0,0,456,248Z"/>
                                        <path d="M300.1914,198.5859l-40.7656,112a7.9976,7.9976,0,1,0,15.0312,5.4688l40.7657-112a7.9976,7.9976,0,0,0-15.0313-5.4688Z"/>
                                        <path d="M188.4844,241.5313a29.3557,29.3557,0,0,0-8.6524-20.8907c-11.164-11.1718-30.6172-11.1718-41.7812,0a29.3437,29.3437,0,0,0-8.6563,20.8907,8,8,0,0,0,16,0,13.4662,13.4662,0,0,1,3.9688-9.5782,13.8555,13.8555,0,0,1,19.1562,0,13.5422,13.5422,0,0,1,0,19.1485l-36.7812,36.7812a7.9993,7.9993,0,0,0,5.6562,13.6563h43.09a8,8,0,0,0,0-16H156.707l23.125-23.125A29.3376,29.3376,0,0,0,188.4844,241.5313Z"/>
                                        <path d="M234.09,301.5391a7.9979,7.9979,0,0,0,8-8v-11.93h4.129a8,8,0,0,0,0-16H242.09v-45.625a8.0028,8.0028,0,0,0-14.6914-4.3906l-35.164,53.625a8.0017,8.0017,0,0,0,6.6914,12.3906H226.09v11.93A7.998,7.998,0,0,0,234.09,301.5391Zm-20.3515-35.93,12.3515-18.836v18.836Z"/>
                                        <path d="M342.9531,293.5391a8,8,0,0,0,16,0V277.07a72.2724,72.2724,0,0,1,21.3047-51.43,7.9993,7.9993,0,0,0-5.6562-13.6562h-47.293a8,8,0,0,0,0,16h30.4258A88.1067,88.1067,0,0,0,342.9531,277.07Z"/>
                                    </g>
                                </svg>
                                <div className="text-center">
                                    <h3 className="font-bold ">Service</h3>
                                    <p className="text-2x1 text-gray-600">
                                        Prenez rendez vous en ligne, 24h/24 et 7j/7
                                    </p>
                                </div>
                            </div>

                        </div>
                    </div>
                </section>
                <Footer />
            </main>
        </div>
    );

}

export default Apropos;